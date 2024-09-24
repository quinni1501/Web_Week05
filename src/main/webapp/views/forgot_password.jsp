<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
	<h1>Forgot Your Password?</h1>
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<form class="form-horizontal" role="form"
					action="${pageContext.request.contextPath}/forgot-password"
					method="post">

					<!-- Display error messages if any -->
					<c:if test="${error != null}">
						<div class="form-group">
							<div class="col-lg-8 col-lg-offset-4">
								<p
									style="font-family: 'Calibri', sans-serif; font-size: 16px; color: red;">
									${error}</p>
							</div>
						</div>
					</c:if>

					<!-- Reset password form -->
					<fieldset>
						<legend>Reset your password</legend>

						<!-- Username field -->
						<div class="form-group">
							<label for="username" class="col-lg-4 control-label">Username
								<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="username"
									name="username" placeholder="Username"
									value="${param.username}" required />
							</div>
						</div>

						<!-- New password field -->
						<div class="form-group">
							<label for="newPassword" class="col-lg-4 control-label">New
								Password <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="password" class="form-control" id="newPassword"
									name="newPassword" placeholder="New password" required />
							</div>
						</div>

						<!-- Confirm new password field -->
						<div class="form-group">
							<label for="confirmPassword" class="col-lg-4 control-label">Confirm
								New Password <span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="password" class="form-control" id="confirmPassword"
									name="confirmPassword" placeholder="Confirm password" required />
							</div>
						</div>
					</fieldset>

					<!-- Submit and cancel buttons -->
					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
							<button type="submit" class="btn btn-primary">Reset
								Password</button>
							<button type="button" class="btn btn-default"
								onclick="window.location.href='${pageContext.request.contextPath}/login'">Cancel</button>
						</div>
					</div>
				</form>
			</div>

			
			<div class="col-md-4 col-sm-4 pull-right">
				
                  <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Enter the e-mail address associated with your account. Click submit to have your password e-mailed to you.</p>

                    <button type="button" class="btn btn-default">More details</button>
                  </div>
			</div>
		</div>
	</div>
</div>
<!-- END CONTENT -->
