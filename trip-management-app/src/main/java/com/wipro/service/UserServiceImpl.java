package com.wipro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.dto.LoginDto;
import com.wipro.dto.RegisterDto;
import com.wipro.dto.ReqRes;
import com.wipro.dto.UpdateUserdto;
import com.wipro.entity.TripBooking;
import com.wipro.entity.TripBus;
import com.wipro.entity.TripFeedback;
import com.wipro.entity.TripPackage;
import com.wipro.entity.Users;
import com.wipro.enums.Role;
import com.wipro.exception.UserException;
import com.wipro.repository.TripBookingRepository;
import com.wipro.repository.TripPackageRepository;
import com.wipro.repository.UsersRepository;
@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private TripBookingRepository tripBookingRepository;
	
	@Autowired
	private TripPackageService tripPackageSerive;
    @Autowired
    private JWTService jwtService;
    
    @Autowired
    private TripPackageRepository tripPackageRepo;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getEmail());
        } else {
            return "fail";
        }
    }
	@Override
	public Users createuser(RegisterDto user) throws UserException {
		try {
			System.out.println("ss");
			Users isUserExist=userRepository.findByEmail(user.getEmail());
			System.out.println(isUserExist);
			if(isUserExist!=null) {
				throw new UserException("User already exist");
			}
			Users userReg=new Users();
			userReg.setName(user.getName());
			userReg.setEmail(user.getEmail());
			userReg.setPassword(encoder.encode(user.getPassword()));
			userReg.setUserLocation(user.getUserLocation());
			userReg.setMobile(user.getMobile());
			userReg.setDateOfBirth(user.getDateOfBirth());
			userReg.setGender(user.getGender());
			userReg.setBookings(new ArrayList<TripBooking>());
			userReg.setTripFeedback(new ArrayList<TripFeedback>());
			userReg.setRole(Role.USER);
			return userRepository.save(userReg);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	@Override
	public List<Users> getAllUsers() throws UserException {
		
		try {
			List<Users> list=userRepository.findAll();
			List<Users> userList = new ArrayList<>();
			for(Users user:list) {
				if(user.getRole()==Role.USER) {
					userList.add(user);
				}
			}
			
			return userList;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	@Override
	public Users getById(Long userId) throws UserException {
		try {
			return userRepository.findById(userId).get();
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}

	}
	@Override
	public Users updateUser(Long userId,UpdateUserdto user) throws UserException {
		try {
			Users userDetail=userRepository.findById(userId).get();
			System.out.println(userDetail);
			userDetail.setName(user.getName());
			userDetail.setEmail(user.getEmail());
			userDetail.setPassword(encoder.encode(user.getPassword()));
			userDetail.setMobile(user.getMobile());
			userDetail.setUserLocation(user.getUserLocation());
			
			return userRepository.save(userDetail);
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	@Override
	public String deleteById(Long userId) throws UserException {
		try {
			
			userRepository.deleteById(userId);
			return userId +" is deleted";
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}
	}
	@Override
	public ReqRes getLogin(LoginDto login) {
//		System.out.println(userRepository.findByEmailAndPassword(login.getEmail(),login.getPassword()));
//		Users user=userRepository.findByEmailAndPassword(login.getEmail(),login.getPassword());
//		return user;
		
		 Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
	    
		 if (authentication.isAuthenticated()) {
	        	Users user=userRepository.findByEmail(login.getEmail());
	        	ReqRes res=new ReqRes();
	        	res.setUserId(user.getUserId());
	        	res.setUsername(user.getName());
	        	res.setEmail(login.getEmail());
	        	res.setToken(jwtService.generateToken(login.getEmail()));
	        	res.setStatusCode(200);
	        	res.setRole(user.getRole().name());
	        	res.setMessage("success");
	            return res;
	        } else {
	    
	        	Users user=userRepository.findByEmail(login.getEmail());
	        	ReqRes res=new ReqRes();
	        	res.setUsername(user.getUsername());
	        	res.setEmail(login.getEmail());
	        	res.setStatusCode(400);
	        	res.setMessage("failed");
	            return res;
	        }
	}
	@Override
	public List<TripBooking> getAllBookingDetails(Long userId) {
		Users user=userRepository.findById(userId).get();
		
		List<TripBooking> listOfBooking=user.getBookings();
		return listOfBooking;
	}
	
	@Override
	public TripBooking cancelBooking(Long bookingId) {
		TripBooking bookingDetail=tripBookingRepository.findById(bookingId).get();
		bookingDetail.setBookingStatus("CANCELED");
		TripBus bus=bookingDetail.getPackages().getBus();
		bus.setAvailableSeat(bus.getAvailableSeat()+bookingDetail.getNoOfPerson());
		TripPackage tripPackage=tripPackageSerive.getPackageById(bookingDetail.getPackages().getPackagedId());
		tripPackage.setBus(bus);
		
		bookingDetail.setPackages(tripPackageRepo.save(tripPackage));
		
		
		return tripBookingRepository.save(bookingDetail);
	}
	
	
}
