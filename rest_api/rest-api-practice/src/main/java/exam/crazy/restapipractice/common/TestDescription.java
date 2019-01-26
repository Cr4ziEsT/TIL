package exam.crazy.restapipractice.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)  // 이 에노테이션을 붙인 코드를 얼마나 오래 가져갈 것인가에 대한 내용, 기본값 = CLASS
public @interface TestDescription {

    String value();
}

// Test 설명용 애노테이션, JUnit 5 부터 `Test`에 설명을 적는 방법이 있다. (이 방법이 더욱 더 좋음)
