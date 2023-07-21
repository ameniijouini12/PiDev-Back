package com.example.pidevge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import com.example.pidevge.Entities.Formation;
import com.example.pidevge.Entities.User;
import com.example.pidevge.Repositories.FormationRepository;
import com.example.pidevge.Repositories.UserRepository;
import com.example.pidevge.services.FormationServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FormationServiceTest {

    @InjectMocks
    private FormationServiceImp formationService;

    @Mock
    public UserRepository userRepository;

    @Mock
    public FormationRepository formationRepository;

    public Formation createFormation() {
        Formation a = new Formation();
        a.setIdFormation(9);
        return a;
    }

    public User createUser() {
        User u = new User();
        u.setIdUser(9);
        return u;
    }

    @Test
    public void assignFormationToUserTest() {
        // Create mock objects
        Formation formation = createFormation();
        User user = createUser();

        // Mock the findById method of formationRepository
        when(formationRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(formation));

        // Mock the findById method of userRepository
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));

        // Mock the save method of formationRepository to return the formation object
        when(formationRepository.save(Mockito.any(Formation.class))).thenReturn(formation);

        // Call the method being tested
        formationService.assignFormationToUser(9, 9);

        // Add any assertions you want to test
        // For example, you can verify that the formation's user has been set to the expected user
        assertEquals(user, formation.getUser());

        // Optionally, you can also verify that the save method was called once with the correct argument
        verify(formationRepository, times(1)).save(formation);
    }

    @Test
    public void testAssignFormationToUser_FormationNotFound() {
        Integer nonExistingFormationId = 99;
        User user = createUser();

        when(formationRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));

        formationService.assignFormationToUser(nonExistingFormationId, user.getIdUser());

        assertNull(user.getFormations()); // Ensure the user's formation is not set
        verify(formationRepository, never()).save(Mockito.any(Formation.class)); // Verify save is not called
    }

    @Test
    public void testAssignFormationToUser_SaveFailure() {
        Formation formation = createFormation();
        User user = createUser();

        when(formationRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(formation));
        when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(user));
        when(formationRepository.save(Mockito.any(Formation.class))).thenReturn(null); // Save failure

        formationService.assignFormationToUser(formation.getIdFormation(), user.getIdUser());

        assertNull(user.getFormations()); // Ensure the user's formation is not set
        verify(formationRepository, times(1)).save(formation);
    }


}
