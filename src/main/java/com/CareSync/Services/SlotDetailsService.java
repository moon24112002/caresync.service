package com.CareSync.Services;

import com.CareSync.Exception.ResourceAlreadyExist;
import com.CareSync.Interfaces.ISlotDetailsService;
import com.CareSync.Models.ApiResponse;
import com.CareSync.Models.SlotDetails;
import com.CareSync.Models.Slots;
import com.CareSync.Repository.SlotDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import  java.util.*;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class SlotDetailsService implements ISlotDetailsService {
    @Autowired
    public SlotDetailsRepository _slotDetailsRepository;
    @Override
    public ResponseEntity<ApiResponse> addSlotDetails(SlotDetails slotDetails) {
        LocalTime startAt = slotDetails.getStartTime();
        LocalTime endAt = slotDetails.getEndTime();
        LocalTime phase = startAt;
        while(phase.isBefore(endAt)){
            Slots slot = new Slots();
            slot.setStartAt(phase);
            phase = phase.plusMinutes(slotDetails.getSlotTime());
            slot.setEndAt(phase);
            slotDetails.addSlot(slot);
        }
        if(_slotDetailsRepository.findSlotsByDoctorId(slotDetails.getDoctorId())!=null){
            throw new ResourceAlreadyExist("SlotDetails already exist for doctorId: " + slotDetails.getDoctorId());
        }
        var res =  _slotDetailsRepository.save(slotDetails);
        return  ResponseEntity.ok(new ApiResponse("success", res));
    }
    @Override
    public ResponseEntity<ApiResponse> getSlotDetailsById(Long id) {
        Optional<SlotDetails> optional =  _slotDetailsRepository.findById(id);
        if(optional.isPresent()) return ResponseEntity.ok(new ApiResponse("success",optional.get()));;
        return ResponseEntity.ok(new ApiResponse("failed"));
    }
    @Override
    public ResponseEntity<ApiResponse> getSlotDetailsByDoctorId(Long id) {
        var data = _slotDetailsRepository.findSlotsByDoctorId(id);
        if(data !=null){
            return ResponseEntity.ok(new ApiResponse("success",data));
        }
        return ResponseEntity.ok(new ApiResponse("failed"));
    }
}
