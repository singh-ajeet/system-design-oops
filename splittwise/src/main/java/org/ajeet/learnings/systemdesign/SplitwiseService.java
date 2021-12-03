package org.ajeet.learnings.systemdesign;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.ajeet.learnings.systemdesign.balance.Balance;
import org.ajeet.learnings.systemdesign.balance.InMemoryBalanceRepository;
import org.ajeet.learnings.systemdesign.user.User;
import org.ajeet.learnings.systemdesign.user.UserRepository;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;

public class SplitwiseService implements Closeable {
    private final static Logger LOG = LoggerFactory.getLogger(SplitwiseService.class);

    private final InMemoryBalanceRepository balanceRepository;
    private final UserRepository userRepository;

    public SplitwiseService(InMemoryBalanceRepository balanceRepository, UserRepository userRepository) {
        this.balanceRepository = balanceRepository;
        this.userRepository = userRepository;
    }

    public Collection<Balance> getBalanceForAll(){
        return balanceRepository.listBalance();
    }

    public Balance getBalanceForUser(String userId){
        User user = userRepository.findUserById(userId);
        if(user == null){
            return null;
        }
        return balanceRepository.findBalanceByUser(user);
    }


    @Override
    public void close() throws IOException {
        try{
            balanceRepository.close();
        } catch(Exception ex) {
                LOG.error("Failed to close Balance Repository", ex);
        }

        try{
            userRepository.close();
        } catch(Exception ex) {
            LOG.error("Failed to close User Repository", ex);
        }
    }
}
