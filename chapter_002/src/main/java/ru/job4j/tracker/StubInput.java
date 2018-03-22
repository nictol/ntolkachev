package ru.job4j.tracker;

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private final String[] valueString;

    private final long[] valueLong;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int positionString;
    private int positionLong;


    public StubInput(String[] valueString, final long[] value) {
        this.valueString = valueString;
        this.valueLong = value;
    }

    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Unsupported operation");
        return -1;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */

    @Override
    public String ask(String question) {
        return this.valueString[this.positionString++];
    }


    @Override
    public long askDate(String question) {
        return this.valueLong[this.positionLong++];
    }

}