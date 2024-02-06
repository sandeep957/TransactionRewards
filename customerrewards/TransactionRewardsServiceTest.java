package com.customer.rewards.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import com.customer.rewards.model.TransactionDetails;
import com.customer.rewards.model.TransactionRewards;
import com.customer.rewards.repository.RewardsRepository;




public class TransactionRewardsServiceTest {

    @Test
    public void testGetLastThreeMonthsRewards() {
        
        RewardsRepository repositoryMock = mock(RewardsRepository.class);

      
        List<TransactionRewards> rewardsList = Arrays.asList(
                new TransactionRewards("abc", LocalDate.now().minusMonths(2), 50),
                new TransactionRewards("abc", LocalDate.now().minusMonths(2), 100),
                new TransactionRewards("abc", LocalDate.now().minusMonths(1), 75)
        );

        
        when(repositoryMock.findByTransactionDateGreaterThanEqual(ArgumentMatchers.any(LocalDate.class)))
                .thenReturn(rewardsList);

       
        TransactionRewardsService rewardsService = new TransactionRewardsService(repositoryMock);

        Map<String, Map<String, Integer>> result = rewardsService.getLastThreeMonthsRewards();

        assertEquals(2, result.size());
        assertEquals(2, result.get("abc").size());
        assertEquals(150, result.get("abc").get("JANUARY"));
        assertEquals(50, result.get("abc").get("DECEMBER"));
    }

    @Test
    public void testSaveTransactionDetails() {
        // Mock the repository
        RewardsRepository repositoryMock = mock(RewardsRepository.class);

        TransactionRewardsService rewardsService = new TransactionRewardsService(repositoryMock);

        TransactionDetails transactionDetails = new TransactionDetails("123", "abc", 120.0);
      

        rewardsService.saveTransactionDetails(transactionDetails);

        
        verify(repositoryMock).save(argThat(transactionRewards ->
                transactionRewards.getCustomerId().equals("123") &&
                transactionRewards.getCustomerName().equals("abc") &&
                transactionRewards.getTransactionAmount().equals(120.0) &&
                transactionRewards.getTransactionDate().equals(LocalDate.now())
        ));
    }
}