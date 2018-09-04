package ru.job4j.tracker;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Tracker {
  /**
   * @version $Id$
   * @since 0.1
   */
  /**
   * Массив для хранение заявок.
   */
  private final Item[] items = new Item[100];

  /**
   * Указатель ячейки для новой заявки.
   */
  private int position = 0;

  /**
   * Метод реализущий добавление заявки в хранилище
   *
   * @param item новая заявка
   */
  public Item add(Item item) {
    item.setId(this.generateId());
    this.items[this.position++] = item;
    return item;
  }

  /**
   * Метод генерирует уникальный ключ для заявки.
   * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
   *
   * @return Уникальный ключ.
   */
  private String generateId() {
    Date date = new Date();
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return date.toString();
  }

  /**
   * Метод удалении ячейки по id
   *
   * @param id
   */
  public void delete(String id) {
    for (int i = 0; i < this.items.length; i++) {
      if (this.items[i].getID().equals(id)) {
        System.arraycopy(this.items, i + 1, this.items, i, position - i - 1);
        this.position--;
        break;
      }
    }
  }

  /**
   * Метод возвращает все элементы, кроме тех, которые null
   *
   * @return массив не нулевых элементов
   */
  public Item[] findAll() {
    Item[] itemsCopy = new Item[100];
    for (int i = 0; i < this.items.length; i++) {
      if (this.items[i] != null) {
        itemsCopy[i] = items[i];
      }
    }
    return itemsCopy;
  }

  /**
   * Метод ищет элемент по имени
   *
   * @param key ключ по которому ищется элемент
   * @return массив элементов с искомым именем
   */
  public Item[] findByName(String key) {
    Item[] itemsCopy = new Item[100];
    int j = 0;
    for (int i = 0; i < position; i++) {
      if (items[i].getName().equals(key)) {
        itemsCopy[j] = items[i];
        j++;
      }
    }
    return itemsCopy;
  }

  /**
   * Етод возвращающий текущую позицию
   */
  public int getPosition() {
    return this.position + 1;
  }

  /**
   * Метод заменяет элемент по ключу
   *
   * @param id   Уникальный ключ
   * @param item Элемент на замену
   */
  public void replace(String id, Item item) {
    Item cell = this.findById(id);
    //cell.setId(item.getID());
    cell.setName(item.getName());
    cell.setDesciption(item.getDescription());
    cell.setCreated(item.getCreated());
    cell.setComments(item.getComments());
  }

  /**
   * Метод ищет элемент по индексу
   *
   * @param id ключ по которому ищется элемент
   * @return элемент с искомым ключом
   */
  Item findById(String id) {
    Item result = null;
    for (int i = 0; i < position; i++) {
      if (items[i].getID().equals(id)) {
        result = items[i];
        break;
      }
    }
    return result;
  }

}