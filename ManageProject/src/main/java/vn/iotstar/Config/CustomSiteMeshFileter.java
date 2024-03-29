package vn.iotstar.Config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomSiteMeshFileter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/leaderLecture/*", "/decorators/admin.jsp")
		.addDecoratorPath("/admin/*", "/decorators/AD.jsp")
				.addDecoratorPath("/student/*", "/decorators/student.jsp")

				.addDecoratorPath("/Home/*", "/decorators/admin.jsp")
				
				.addDecoratorPath("/lecture/*", "/decorators/lecture.jsp")
				
				.addDecoratorPath("/leadlecture/*", "/decorators/leadlecture.jsp")

				.addDecoratorPath("/notification/*", "/decorators/AD.jsp")

				.addDecoratorPath("/account/*", "/decorators/admin.jsp")
				.addDecoratorPath("/*", "/decorators/web.jsp")
				.addDecoratorPath("/admin/testtrang", "/decorators/AD.jsp")
				.addExcludedPath("/login*")
				.addExcludedPath("/logout");
	}
}

/*
 * .addDecoratorPath("/*", "/decorators/web.jsp")
 */
