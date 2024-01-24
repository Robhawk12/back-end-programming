package rjo.spring.demo.services;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@Getter
@Setter
public class PurchaseResponse {

    private final String orderTrackingNumber;
}
