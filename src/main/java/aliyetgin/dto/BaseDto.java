package aliyetgin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

// Lombok
@Data
@AllArgsConstructor

abstract public class BaseDto {
    private Long id;
    private Date createdDate;

    // Constructor without parameters
    public BaseDto() {
        this.createdDate=new Date(System.currentTimeMillis()); // 10 August 1990
    }
}
