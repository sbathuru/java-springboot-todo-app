<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ include file="common/header.jspf" %>
			<%@ include file="common/navigation.jspf" %>

				<!DOCTYPE html>
				<html lang="en">

				<head>
					<spring:url value="/resources/images" var="images" />
				</head>

				<body>
					<div class="container">
						<img alt="Devops Flow" src="https://sysdig.com/wp-content/uploads/Blog-Kubernetes-Monitoring-with-Prometheus-4-Architecture-Overview.png" style="width:700px;height:250px;" /></br>
					</div>

					<div class=" container">
						<div class="row">
							<div class="col-md-8"> </br>
								<h4>Srini Devops Lab, Hyd.</h4>
								<h5>Contact @ +91-9876543210</h5> <br>

								<table>
									<tr>
										<td style="width: 150px">
											IP Address
										</td>
										<td>${ipaddress}</td>
									</tr>
									<tr>
										<td>
											Current USER
										</td>
										<td>${currUser}</td>
									</tr>
									<tr>
										<td>
											PResent Working DIR</td>
										<td>${pwd}</td>
									</tr>
									<tr>
										<td>
											Configmap Value
										</td>
										<td>${configmapValue}</td>
									</tr>
									<tr>
										<td>
											Secrets Value
										</td>
										<td>${secretsValue}</td>
									</tr>
								</table>
							</div>
						</div>
						<hr>
						<footer>
							<h5>&copy; Srini Labs 2021</h5>
							<h6 id='ct' style=" text-align:right;">
							</h6>
						</footer>
					</div>

				</body>

				</html>
				<%@ include file="common/footer.jspf" %>