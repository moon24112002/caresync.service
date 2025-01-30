package com.CareSync.Interfaces;
import java.util.*;

import com.CareSync.Models.ApiResponse;
import com.CareSync.Models.SlotDetails;
import org.springframework.http.ResponseEntity;

public interface ISlotDetailsService {
    public ResponseEntity<ApiResponse> addSlotDetails(SlotDetails slotDetails);
    public ResponseEntity<ApiResponse> getSlotDetailsById(Long id);
    public ResponseEntity<ApiResponse> getSlotDetailsByDoctorId(Long id);

}
