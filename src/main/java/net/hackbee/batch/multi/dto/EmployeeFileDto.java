package net.hackbee.batch.multi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Hackbee on 4/18/2017.
 */
@Data
public class EmployeeFileDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String alias;
    private String phoneNumber;
    private String creditCardNumber;

}
