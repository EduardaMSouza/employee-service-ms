import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:9191/api/employee";

const EMPLOYEE_ID = 7;

class EmployeeService {
  getEmployee() {
    return axios.get(EMPLOYEE_API_BASE_URL + '/' + EMPLOYEE_ID);
  }

}

const employeeService = new EmployeeService();
export default employeeService;