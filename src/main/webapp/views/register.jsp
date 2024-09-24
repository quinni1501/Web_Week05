<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
	<h1>Create an account</h1>
	<div class="content-form-page">
		<div class="row">
			<div class="col-md-7 col-sm-7">
				<form class="form-horizontal" role="form"
					action="${pageContext.request.contextPath}/register" method="post">
					<fieldset>
						<legend>Your personal details</legend>
						<div class="form-group">
							<label for="username" class="col-lg-4 control-label">Username
								<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="username"
									name="username"
									value="${param.username}" required />
							</div>
						</div>
						<div class="form-group">
							<label for="fullname" class="col-lg-4 control-label">Full
								Name<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="fullname"
									name="fullname" required />
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-lg-4 control-label">Email<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="email" name="email"
									required />
							</div>
						</div>
					</fieldset>
					<fieldset>
						<legend>Your password</legend>
						<div class="form-group">
							<label for="fullname" class="col-lg-4 control-label">Password<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="password" name="password"
									required />
							</div>
						</div>
						<div class="form-group">
							<label for="confirm_password" class="col-lg-4 control-label">Confirm Password<span class="require">*</span>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="confirm_password" name="confirm_password"
									required />
							</div>
						</div>
					</fieldset>
					
					<div class="row">
						<div
							class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
							<button type="submit" class="btn btn-primary">Create an
								account</button>
							<button type="button" class="btn btn-default" onclick="window.location.href='${pageContext.request.contextPath}/login'">Cancel</button>

						</div>
					</div>
				</form>
			</div>
			<div class="col-md-4 col-sm-4 pull-right">
				<div class="form-info">
					<h2>
						<em>Important</em> Information
					</h2>
					<p>Lorem ipsum dolor ut sit ame dolore adipiscing elit, sed sit
						nonumy nibh sed euismod ut laoreet dolore magna aliquarm erat sit
						volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl
						aliquip commodo quat.</p>

					<p>Duis autem vel eum iriure at dolor vulputate velit esse vel
						molestie at dolore.</p>

					<button type="button" class="btn btn-default">More details</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END CONTENT -->
