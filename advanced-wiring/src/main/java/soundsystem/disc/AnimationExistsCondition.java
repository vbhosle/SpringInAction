package soundsystem.disc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class AnimationExistsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext ctx, AnnotatedTypeMetadata metadata) {
		Environment env = ctx.getEnvironment();
		return env.containsProperty("animation") && env.getProperty("animation", Boolean.class) == true;
	}

}
