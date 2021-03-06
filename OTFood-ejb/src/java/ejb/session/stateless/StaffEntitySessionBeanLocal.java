/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.StaffEntity;
import java.util.List;
import javax.ejb.Local;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.StaffNotFoundException;
import util.exception.StaffUsernameExistException;
import util.exception.UnknownPersistenceException;
import util.exception.UpdateStaffException;

/**
 *
 * @author Mitsuki
 */
@Local
public interface StaffEntitySessionBeanLocal {

    public Long createNewStaff(StaffEntity newStaff) throws StaffUsernameExistException, UnknownPersistenceException, InputDataValidationException;

    public List<StaffEntity> retrieveAllStaff();

    public StaffEntity retrieveStaffByUsername(String username) throws StaffNotFoundException;

    public StaffEntity retrieveStaffById(Long id) throws StaffNotFoundException;

    public StaffEntity staffLogin(String username, String password) throws InvalidLoginCredentialException;

    public void updateStaff(StaffEntity staff) throws StaffNotFoundException, UpdateStaffException, InputDataValidationException;

    public void updatePassword(StaffEntity staff, String oldPassword, String newPassword) throws InvalidLoginCredentialException, StaffNotFoundException;

    public void deleteStaff(Long id) throws StaffNotFoundException;

}
