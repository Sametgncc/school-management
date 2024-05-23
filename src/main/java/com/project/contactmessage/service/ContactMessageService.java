package com.project.contactmessage.service;


import com.project.contactmessage.dto.ContactMessageResponse;
import com.project.contactmessage.repository.ContactMessageRepository;
import com.project.payload.response.business.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ResponseMessage<ContactMessageResponse> save(ContactMessageService contactMessageService) {


    }
}
