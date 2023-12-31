import "bootstrap"
import React, { Component } from "react"

class HeaderComponent extends Component {
	constructor(props) {
		super(props)

		this.state = {}
	}

	render() {
		return (
			<div style={{ width: "120%" }}>
				<header>
					<nav className='navbar navbar-expand-lg bg-dark'>
						<div className='container-fluid'>
							<a
								style={{ marginLeft: "20px", color: "white" }}
								className='navbar-brand'
								href='http://localhost:3000/'
							>
								<img
									style={{ marginRight: "10px", color: "white" }}
									src='/resources/logo.svg'
									alt=''
									width='30'
									height='30'
									className='d-inline-block align-text-bottom'
								/>
								Time Management System
							</a>
							<button
								className='navbar-toggler'
								type='button'
								data-bs-toggle='collapse'
								data-bs-target='#navbarNavDropdown'
								aria-controls='navbarNavDropdown'
								aria-expanded='false'
								aria-label='Toggle navigation'
							>
								<span className='navbar-toggler-icon'></span>
							</button>
							<div className='collapse navbar-collapse' id='navbarNavDropdown'>
								<ul className='navbar-nav'>
									<li class='nav-item'>
										<a
											style={{ color: "white" }}
											class='nav-link'
											href='http://localhost:3000/summary/employee'
										>
											Сотрудники
										</a>
									</li>

									<li class='nav-item'>
										<a
											style={{ color: "white" }}
											class='nav-link'
											href='http://localhost:3000/summary/position'
										>
											Должности
										</a>
									</li>

									<li class='nav-item'>
										<a
											style={{ color: "white" }}
											class='nav-link'
											href='http://localhost:3000/summary/department'
										>
											Отделы
										</a>
									</li>

									<li class='nav-item'>
										<a
											style={{ color: "white" }}
											class='nav-link'
											href='http://localhost:3000/summary/deviation'
										>
											Отклонения
										</a>
									</li>
									<li class='nav-item'>
										<a
											style={{ color: "white" }}
											class='nav-link'
											href='http://localhost:3000/summary/timeSheet'
										>
											Табели рабочего времени
										</a>
									</li>
									<li class='nav-item'>
										<a
											style={{ color: "white" }}
											class='nav-link'
											href='http://localhost:3000/summary/distraction'
										>
											Табели отвлечений
										</a>
									</li>
									<li class='nav-item'>
										<a
											style={{ color: "white" }}
											class='nav-link'
											href='http://localhost:3000/summary/rest'
										>
											Табели перерывов
										</a>
									</li>

									<li className='nav-item dropdown'>
										<a
											style={{ color: "white" }}
											className='nav-link dropdown-toggle'
											href='#'
											id='navbarDropdownMenuLink'
											role='button'
											data-bs-toggle='dropdown'
											aria-expanded='false'
										>
											Настройки
										</a>
										<ul
											className='dropdown-menu'
											aria-labelledby='navbarDropdownMenuLink'
										>
											<li>
												<a
													className='dropdown-item'
													href='http://localhost:3000/settings/limits'
												>
													Лимиты
												</a>
											</li>
											<li>
												<hr class='dropdown-divider' />
											</li>
											<li>
												<a
													className='dropdown-item'
													href='http://localhost:3000/settings/privilege'
												>
													Привилегии
												</a>
											</li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
					</nav>
				</header>
			</div>
		)
	}
}

export default HeaderComponent
