package wdsr.exercise3.hr;

import java.net.URL;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import wdsr.exercise3.hr.ws.EmployeeType;
import wdsr.exercise3.hr.ws.HolidayRequest;
import wdsr.exercise3.hr.ws.HolidayResponse;
import wdsr.exercise3.hr.ws.HolidayType;
import wdsr.exercise3.hr.ws.HumanResource;
import wdsr.exercise3.hr.ws.HumanResourceService;

// TODO Complete this class to book holidays by issuing a request to Human Resource web service.
// In order to see definition of the Human Resource web service:
// 1. Run HolidayServerApp.
// 2. Go to http://localhost:8090/holidayService/?wsdl
public class HolidayClient {
	
	private HumanResourceService humanResourceService;
	
	/**
	 * Creates this object
	 * @param wsdlLocation URL of the Human Resource web service WSDL
	 */
	public HolidayClient(URL wsdlLocation) {
		humanResourceService = new HumanResourceService(wsdlLocation);
	}
	
	/**
	 * Sends a holiday request to the HumanResourceService.
	 * @param employeeId Employee ID
	 * @param firstName First name of employee
	 * @param lastName Last name of employee
	 * @param startDate First day of the requested holiday
	 * @param endDate Last day of the requested holiday
	 * @return Identifier of the request, if accepted.
	 * @throws ProcessingException if request processing fails.
	 */
	
	private HolidayRequest createHolidayRequest(int employeeId, String firstName, String lastName, Date startDate, Date endDate) throws DatatypeConfigurationException {
	    HolidayRequest holidayRequest = new HolidayRequest();
	    holidayRequest.setEmployee(createHolidayRequestEmployee(employeeId, firstName, lastName));
	    holidayRequest.setHoliday(createHolidayRequestHoliday(startDate, endDate));
	    return holidayRequest;
	}
	
	private EmployeeType createHolidayRequestEmployee(int employeeId, String firstName, String lastName) {
	    EmployeeType employee = new EmployeeType();
	    employee.setNumber(employeeId);
	    employee.setFirstName(firstName);
	    employee.setLastName(lastName);
	    return employee;
	}
	
	private HolidayType createHolidayRequestHoliday(Date startDate, Date endDate) throws DatatypeConfigurationException {
	    HolidayType holiday = new HolidayType();
	    holiday.setStartDate(startDate);
	    holiday.setEndDate(endDate);
	    return holiday;
	}
	
	public int bookHoliday(int employeeId, String firstName, String lastName, Date startDate, Date endDate) throws ProcessingException {
		HumanResource humanResource = humanResourceService.getHumanResourcePort();
        try {
            HolidayResponse response;
            response = humanResource.holiday(createHolidayRequest(employeeId, firstName, lastName, startDate, endDate));
            return response.getRequestId();
        } 
        catch (Exception e) {
            throw new ProcessingException();
        }
	}
}
