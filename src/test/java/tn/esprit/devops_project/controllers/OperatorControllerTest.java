package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class OperatorControllerTest {
    @Mock
    private OperatorRepository operatorRepositoryMock;
    @InjectMocks
    private OperatorController operatorController;
    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Test
    public void testRetrieveAllOperators() {
        List<Operator> expectedOperators = Arrays.asList(
                new Operator(1L, "Operator A","A","nassim123", new HashSet<>()),
                new Operator(2L, "Operator B","B","nassim123", new HashSet<>())
        );

        when(operatorRepositoryMock.findAll()).thenReturn(expectedOperators);
        List<Operator> actualOperators = operatorService.retrieveAllOperators();

        assertEquals(expectedOperators.size(), actualOperators.size());
        assertEquals(expectedOperators, actualOperators);

    }

    @Test
    void addOperator() {
        Operator newOperator = new Operator(1L,"operator 1" ,"1" ,"nassim123",new HashSet<>());
        when(operatorService.addOperator(newOperator)).thenReturn(newOperator);

        Operator addedOperator = operatorController.addOperator(newOperator);

        assertEquals(newOperator, addedOperator);
    }

    @Test
    void removeOperator() {
        Long operatorId = 1L;
        operatorController.removeOperator(operatorId);
        verify(operatorService, times(1)).deleteOperator(operatorId);
    }


    @Test
    void modifyOperateur() {
        Operator modifiedOperator = new Operator(1L,"operator 1" ,"1" ,"nassim123",new HashSet<>());
        when(operatorService.updateOperator(modifiedOperator)).thenReturn(modifiedOperator);
        Operator updatedOperator  = operatorController.modifyOperateur(modifiedOperator);
        assertEquals(modifiedOperator, updatedOperator);
    }
}