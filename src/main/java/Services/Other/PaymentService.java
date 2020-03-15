package Services.Other;

import entity.User;

import java.math.BigInteger;

public interface PaymentService {
     boolean processPayment(User fromUser, User toUser, BigInteger amount);


}
