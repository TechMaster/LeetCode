package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class Test1365 {
    @Test void method1() {
        LeetCode1365 app = new LeetCode1365();
        int[] nums = new int[]{8,1,2,2,3};
        var out = app.smallerNumbersThanCurrent2(nums);
        assertThat(out).containsExactly(new int[]{4,0,1,1,3});

        nums = new int[]{6,5,4,8};
        out = app.smallerNumbersThanCurrent3(nums);
        assertThat(out).containsExactly(new int[]{2,1,0,3});
    }
}
