package org.cts.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cts.exception.InvalidTraineeDataException;

public class Validator {

	public boolean checkEmpId(int empId) throws InvalidTraineeDataException {
		boolean flag=false;
		if (Integer.toString(empId).length()!=6) {
			throw new InvalidTraineeDataException("Empid should have 6 numbers");
		}else {
			flag=true;
		}
		return flag;		
	}

	public boolean checkName(String name) throws InvalidTraineeDataException {
		boolean flag=false;
		char[] charArray=name.toCharArray();
		for(char ch: charArray) {
			if(Character.isDigit(ch)) {
				throw new InvalidTraineeDataException("Name should not have numeric value");
			}else {
				flag=true;
			}
		}
		return flag;
		
	}

	public boolean checkEmail(String email) throws InvalidTraineeDataException {
		boolean flag=false;
		String emailRegex="^[A-Za-z0-9+-_.]+@(.+)$";
		Pattern emailPattern=Pattern.compile(emailRegex);
		Matcher emailMatcher=emailPattern.matcher(email);
		if(!emailMatcher.matches()) {
			throw new InvalidTraineeDataException("Check the email format");
		}
		else {
			flag= true;
		}
		return flag;
	}

	public boolean checkCohortCode(String cohortCode) throws InvalidTraineeDataException {
		boolean flag=false;
		String cohortRegex="^[A-Za-z]{3}[0-9]{2}[A-Za-z]{2}[0-9]{2}";
		Pattern cohortPattern=Pattern.compile(cohortRegex);
		Matcher cohortMatcher=cohortPattern.matcher(cohortCode);
		if(!cohortMatcher.matches()) {
			throw new InvalidTraineeDataException("Check the cohortcode format");
		}
		else {
			flag= true;
		}
		return flag;
	}

}
