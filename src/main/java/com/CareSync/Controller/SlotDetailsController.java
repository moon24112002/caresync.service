package com.CareSync.Controller;


import com.CareSync.Models.ApiResponse;
import com.CareSync.Models.SlotDetails;
import com.CareSync.Services.SlotDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slotDetails")

public class SlotDetailsController {

    @Autowired
    private SlotDetailsService _slotDetailsService;

    @PostMapping
    public ResponseEntity<ApiResponse> addSlotDetails(@RequestBody SlotDetails slotDetails){
        return _slotDetailsService.addSlotDetails(slotDetails);
    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getSlotDetailsById(@PathVariable Long id){
        return _slotDetailsService.getSlotDetailsById(id);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getSlotDetailsByDoctorId(@RequestParam Long doctorId){
        return _slotDetailsService.getSlotDetailsByDoctorId(doctorId);
    }
}
