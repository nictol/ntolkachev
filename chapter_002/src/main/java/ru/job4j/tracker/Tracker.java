package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tracker {
  /**
   * @version $Id$
   * @since 0.1
   */
  /**
   * Список для хранение заявок.
   */
  private final List<Item> items = new ArrayList<>();

  /**
   * Метод реализущий добавление заявки в хранилище
   *
   * @param item новая заявка
   */
  public Item add(Item item) {
    item.setId(this.generateId());
    this.items.add(item);
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
    Item deletedItem = null;
    for (Item item : this.items) {
      if (item.getID().equals(id)) {
        deletedItem = item;
      }
    }
    this.items.remove(deletedItem);
  }

  /**
   * Метод возвращает все элементы
   *
   * @return список не нулевых элементов
   */
  public List<Item> findAll() {
    return this.items;
  }

  /**
   * Метод ищет элемент по имени
   *
   * @param key ключ по которому ищется элемент
   * @return список элементов с искомым именем
   */
  public List<Item> findByName(String key) {
    List<Item> findResult = new ArrayList<>();
    for (Item item : this.items) {
      if (item.getName().equals(key)) {
         findResult.add(item);
      }
    }
    return findResult;
  }

  /**
   * Метод заменяет элемент по ID
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
   * Метод ищет элемент по ID
   *
   * @param id ключ по которому ищется элемент
   * @return элемент с искомым ключом
   */
  Item findById(String id) {
    Item result = null;
    for (Item item : this.items) {
      if (item.getID().equals(id)) {
        result = item;
      }
    }
    return result;
  }

}