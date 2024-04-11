package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class OperatorControllerTest {
    @Mock
    private OperatorRepository operatorRepositoryMock;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Test
    public void testRetrieveAllOperators() {
        // Arrange
        List<Operator> expectedOperators = Arrays.asList(
                new Operator(1L, "Operator A","A","nassim123", new HashSet<>()),
                new Operator(2L, "Operator B","B","nassim123", new HashSet<>())
                // Add more operators as needed
        );

        when(operatorRepositoryMock.findAll()).thenReturn(expectedOperators);
        List<Operator> actualOperators = operatorService.retrieveAllOperators();

        assertEquals(expectedOperators.size(), actualOperators.size());
        assertEquals(expectedOperators, actualOperators);

    }
}