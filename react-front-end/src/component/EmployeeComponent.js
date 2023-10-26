import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: {},
      department: {},
      organization: {},
    };
  }

  componentDidMount() {
    EmployeeService.getEmployee().then((res) => {
      this.setState({
        employees: res.data.employee,
        department: res.data.department,
        organization: res.data.organization,
      });
    });
  }

  render() {
    return (
      <div className='container'>
        {/* Employee Details */}
        <div className='card offset-md-3'>
          <h3 className='text-center card-header'>Employee Details</h3>
          <div className='card-body'>
            <div className='row'>
              <div className='col-md-6'>
                <label>Employee First name:</label>
              </div>
              <div className='col-md-6'>
                {this.state.employees.firstName}
              </div>
            </div>
            <div className='row'>
              <div className='col-md-6'>
                <label>Employee last name:</label>
              </div>
              <div className='col-md-6'>
                {this.state.employees.lastName}
              </div>
            </div>
            <div className='row'>
              <div className='col-md-6'>
                <label>Employee Email:</label>
              </div>
              <div className='col-md-6'>
                {this.state.employees.email}
              </div>
            </div>
          </div>
        </div>

        {/* Department Details */}
        <div className='card offset-md-3'>
          <h3 className='text-center card-header'>Department Details</h3>
          <div className='card-body'>
            <div className='row'>
              <div className='col-md-6'>
                <label>Department Name:</label>
              </div>
              <div className='col-md-6'>
                {this.state.department.departmentName}
              </div>
            </div>
            <div className='row'>
              <div className='col-md-6'>
                <label>Department Description:</label>
              </div>
              <div className='col-md-6'>
                {this.state.department.departmentDescription}
              </div>
            </div>
            <div className='row'>
              <div className='col-md-6'>
                <label>Department code:</label>
              </div>
              <div className='col-md-6'>
                {this.state.department.departmentCode}
              </div>
            </div>
          </div>
        </div>

        {/* Organization Details */}
        <div className='card offset-md-3'>
          <h3 className='text-center card-header'>Organization Details</h3>
          <div className='card-body'>
            <div className='row'>
              <div className='col-md-6'>
                <label>Organization Name:</label>
              </div>
              <div className='col-md-6'>
                {this.state.organization.organizationName}
              </div>
            </div>
            <div className='row'>
              <div className='col-md-6'>
                <label>Organization Description:</label>
              </div>
              <div className='col-md-6'>
                {this.state.organization.organizationDescription}
              </div>
            </div>
            <div className='row'>
              <div className='col-md-6'>
                <label>Organization code:</label>
              </div>
              <div className='col-md-6'>
                {this.state.organization.organizationCode}
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default EmployeeComponent;
