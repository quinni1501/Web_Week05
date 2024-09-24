<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
	<h1>Login</h1>
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<form class="form-horizontal form-without-legend" role="form"
					action="${pageContext.request.contextPath}/login" method="post">
					<c:if test="${alert != null}">
						<div class="form-group">
							<div class="col-lg-8 col-lg-offset-4">
								<p
									style="font-family: 'Calibri', sans-serif; font-size: 16px; color: red;">
									${alert}</p>
							</div>
						</div>
					</c:if>
					<div class="form-group">
						<label for="username" class="col-lg-4 control-label">Username
							<span class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="text" class="form-control" id="username"
								placeholder="Enter Username" name="username"
								value="${param.username}" required />
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-lg-4 control-label">Password
							<span class="require">*</span>
						</label>
						<div class="col-lg-8">
							<input type="text" class="form-control" id="password"
								placeholder="Enter Password" name="password" required>

						</div>

					</div>

					<div class="row">
						<div class="col-lg-8 col-md-offset-4">
							<!-- Flexbox for alignment with a smaller left margin -->
							<div
								style="display: flex; justify-content: space-between; align-items: center; margin-left: -9px;">
								<label><input type="checkbox" name="remember">
									Remember me</label> <a
									href="${pageContext.request.contextPath}/forgot-password">Forgot
									Password?</a>
							</div>
						</div>
					</div>
					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
							<button type="submit" class="btn btn-primary">Login</button>
							<a href="${pageContext.request.contextPath}/register"
								class="btn btn-default">Register</a>
						</div>
					</div>
					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
							<hr>
							<div class="login-socio">
								<p class="text-muted">or login using:</p>
								<ul class="social-icons">
									<li><a href="#" data-original-title="facebook"
										class="facebook" title="facebook"></a></li>
									<li><a href="#" data-original-title="Twitter"
										class="twitter" title="Twitter"></a></li>
									<li><a href="#" data-original-title="Google Plus"
										class="googleplus" title="Google Plus"></a></li>
									<li><a href="#" data-original-title="Linkedin"
										class="linkedin" title="LinkedIn"></a></li>
								</ul>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4 col-sm-4 pull-right">
				<div class="form-info">
					<h2>
						<em>Important</em> Information
					</h2>
					<p>Duis autem vel eum iriure at dolor vulputate velit esse vel
						molestie at dolore.</p>

					<button type="button" class="btn btn-default">More details</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END CONTENT -->





