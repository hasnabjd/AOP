import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeItAspect {

    @Around("@annotation(timeIt)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint, TimeIt timeIt) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Method " + joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");

        return result;
    }
}
