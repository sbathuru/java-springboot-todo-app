<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ include file="common/header.jspf" %>
			<%@ include file="common/navigation.jspf" %>

				<!DOCTYPE html>
				<html lang="en">

				<head>
					<spring:url value="/resources" var="images" />
				</head>

				<body>
					<div class="container">
						<img alt="Devops Flow" src="img/devops.jpg" style="width:1000px;height:350px;" /></br>
					</div>

					<div class=" container">
						<div class="row">
							<div class="col-md-8"> </br>

								<table style="font-size: 12pt">
									<tr>
										<td style="width: 200px">
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
											Present Working DIR</td>
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
							<h4>Srini Devops Lab, Hyd.</h4>
							<h5>Contact @ +91-9876543210</h5>
							<h5>&copy; Srini Labs 2021</h5>
							<h6 id='ct' style=" text-align:right;">
							</h6>
						</footer>
					</div>

				</body>

				</html>
				<%@ include file="common/footer.jspf" %>