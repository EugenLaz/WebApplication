package Services.Other.impl;

import Services.Data.impl.UserDaoServiceImpl;
import Services.Other.PaymentService;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Transactional
@Service
public class PayMentServiceImpl implements PaymentService {

    @Autowired
    UserDaoServiceImpl dao;

    @Override
    public boolean processPayment(User fromUser, User toUser, BigInteger amount) {
        if (amount.signum() != 1)
            return false;
        if (fromUser.getBalance().compareTo(amount) < 0) {
            return false;
        }
        fromUser.setBalance(fromUser.getBalance().subtract(amount));
        toUser.setBalance(toUser.getBalance().add(amount));
        dao.saveUser(fromUser);
        dao.saveUser(toUser);
        return true;
    }
}
