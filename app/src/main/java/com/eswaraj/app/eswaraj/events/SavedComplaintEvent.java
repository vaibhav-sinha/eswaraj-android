package com.eswaraj.app.eswaraj.events;


import com.eswaraj.app.eswaraj.base.BaseEvent;
import com.eswaraj.app.eswaraj.models.ComplaintPostResponseDto;
import com.eswaraj.web.dto.ComplaintDto;

public class SavedComplaintEvent extends BaseEvent {

    private ComplaintPostResponseDto complaintPostResponseDto;

    public ComplaintPostResponseDto getComplaintPostResponseDto() {
        return complaintPostResponseDto;
    }

    public void setComplaintPostResponseDto(ComplaintPostResponseDto complaintPostResponseDto) {
        this.complaintPostResponseDto = complaintPostResponseDto;
    }
}
