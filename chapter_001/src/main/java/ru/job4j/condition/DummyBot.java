package ru.job4j.condition;


/**
 * @author Tolkachev Nikita (nictol76@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class DummyBot {
    /**
     * Отвечает на вопросы.
     *
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String answer = "";
        if (question == "Привет, Бот.") answer = "Привет, умник.";
          else if (question == "Пока.") answer = "До скорой встречи.";
            else answer="Это ставит меня в тупик. Спросите другой вопрос.";

        return answer;
    }
}