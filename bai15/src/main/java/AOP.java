import org.apache.commons.lang3.math.NumberUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AOP {
    private boolean isNumber = false;

    @Before("execution(* bai15.Sum.sum(..)) && args(str1, str2)")
    public void validateBefore(JoinPoint joinPoint , String str1, String str2){
        if (!(NumberUtils.isParsable(str1) && NumberUtils.isParsable(str2))){
            throw new NumberFormatException();
        }
    }
}
