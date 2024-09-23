package practiceform.components;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String month, String day, String year) {
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day)
                .shouldNotHave(cssClass(".react-datepicker__day--outside-month"));
    }
}
