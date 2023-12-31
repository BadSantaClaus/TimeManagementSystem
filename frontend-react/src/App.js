import "react-bootstrap-table-next/dist/react-bootstrap-table2.min.css"
import { Route, BrowserRouter as Router, Switch } from "react-router-dom"
import CreateOrUpdateSettingsComponent from "./components/CrateOrUpdateSettingsComponent"
import CreateOrEditDepartmentComponent from "./components/CreateOrEditDepartmentComponent"
import CreateOrUpdateDistractionComponent from "./components/CreateOrUpdateDistractionComponent"
import CreateOrUpdateEmployeeComponent from "./components/CreateOrUpdateEmployee"
import CreateOrUpdatePositionComponent from "./components/CreateOrUpdatePositionComponent"
import CreateOrUpdateRestComponent from "./components/CreateOrUpdateRestComponent.jsx"
import CreateOrUpdateTimeSheetComponent from "./components/CreateOrUpdateTimeSheetComponent"
import DepartmentSummaryComponent from "./components/DepartmentSummaryComponent"
import DeviationSummaryComponent from "./components/DeviationSummaryComponent"
import DistractionComponent from "./components/DistractionComponent"
import EmployeeSummaryComponent from "./components/EmployeeSummaryComponent"
import HeaderComponent from "./components/HeaderComponent"
import PositionSummaryComponent from "./components/PositionSummaryComponent"
import PrivilegeComponent from "./components/PrivilegeComponent"
import RestSummaryComponent from "./components/RestSummaryComponent"
import SettingsComponent from "./components/SettingsComoponent"
import TimeSheetComponent from "./components/TimeSheetComponent"
import UpdatePrivilegeComponent from "./components/UpdatePriivlegeComponent"

function App() {
	return (
		<div>
			<Router>
				<HeaderComponent />
				<div className='container'>
					<Switch>
						<Route path='/' exact component={EmployeeSummaryComponent} />
						<Route
							path='/summary/department'
							component={DepartmentSummaryComponent}
						/>
						<Route
							path='/add-department/:id'
							component={CreateOrEditDepartmentComponent}
						/>
						<Route
							path='/add-department/add'
							component={CreateOrEditDepartmentComponent}
						/>
						<Route
							path='/summary/position'
							component={PositionSummaryComponent}
						/>
						<Route
							path='/add-position/:id'
							component={CreateOrUpdatePositionComponent}
						/>
						<Route
							path='/add-position/add'
							component={CreateOrUpdatePositionComponent}
						/>
						<Route
							path='/summary/employee'
							component={EmployeeSummaryComponent}
						/>
						<Route
							path='/add-employee/:id'
							component={CreateOrUpdateEmployeeComponent}
						/>
						<Route
							path='/add-employee/add'
							component={CreateOrUpdateEmployeeComponent}
						/>
						<Route
							path='/summary/deviation'
							component={DeviationSummaryComponent}
						/>
						<Route path='/summary/timeSheet' component={TimeSheetComponent} />
						<Route
							path='/add-timeSheet/:id'
							component={CreateOrUpdateTimeSheetComponent}
						/>
						<Route
							path='/add-timeSheet/add'
							component={CreateOrUpdateTimeSheetComponent}
						/>

						<Route
							path='/summary/distraction'
							component={DistractionComponent}
						/>
						<Route
							path='/add-distraction/:id'
							component={CreateOrUpdateDistractionComponent}
						/>
						<Route
							path='/add-distraction/add'
							component={CreateOrUpdateDistractionComponent}
						/>
						<Route path='/summary/rest' component={RestSummaryComponent} />
						<Route
							path='/add-rest/:id'
							component={CreateOrUpdateRestComponent}
						/>
						<Route
							path='/add-rest/add'
							component={CreateOrUpdateRestComponent}
						/>
						<Route path='/settings/limits' component={SettingsComponent} />
						<Route
							path='/add-settings/:id'
							component={CreateOrUpdateSettingsComponent}
						/>
						<Route
							path='/add-settings/add'
							component={CreateOrUpdateSettingsComponent}
						/>
						<Route path='/settings/privilege' component={PrivilegeComponent} />
						<Route
							path='/upd-privilege/:id'
							component={UpdatePrivilegeComponent}
						/>
					</Switch>
				</div>
			</Router>
		</div>
	)
}

export default App
