import com.example.AlexLion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {
    @Mock
    Feline feline;

    @Test
    public void getFriendsTest() throws Exception {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        AlexLion alex = new AlexLion(feline);
        List<String> actual = alex.getFriends();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        String expected = "Нью-Йоркский зоопарк";
        AlexLion alex = new AlexLion(feline);
        String actual = alex.getPlaceOfLiving();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() throws Exception {
        AlexLion alex = new AlexLion(feline);
        int actual = alex.getKittens();
        Assert.assertEquals(0, actual);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        AlexLion alex = new AlexLion(feline);
        boolean actual = alex.doesHaveMane();
        Assert.assertTrue(actual);
    }
}
