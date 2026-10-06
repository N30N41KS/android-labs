# Лабораторные работы по Android (1–7)

Все лабораторные работы выполняются в рамках единого проекта со сквозной навигацией с главного экрана (`MainActivity`).

## Навигация по работам

| Лабораторная работа | Экран / Файл логики | Файл разметки | Что реализовано |
| :--- | :--- | :--- | :--- |
| **№1. Первое приложение** | `MainActivity.kt` | `activity_main.xml` | Вывод ФИО и группы через строковый ресурс `@string/fio` |
| **№2. Работа с элементами** | `MainActivity.kt` | `activity_main.xml` | Ввод текста в `EditText`, кнопка «Показать», вывод в `TextView` |
| **№3. Работа с экранами** | `MainActivity2.kt` | `activity_main2.xml` | Переход на экран 2 через `Intent`, передача текста, кнопка «1» (`finish`) |
| **№4. Стили и темы** | `Lab4Activity.kt` | `activity_lab4.xml` | Кастомный стиль `MyTextStyle`, кастомная тема `Theme.MyLab4` |
| **№5. Списки** | `Lab5Activity.kt`, `MyAdapter.kt` | `activity_lab5.xml`, `item.xml` | Пользовательский список `RecyclerView` с изображениями и текстом |
| **№6. Анимация** | `Lab6Activity.kt` | `activity_lab6.xml` | Анимация вращения (`rotate.xml`) и масштабирования (`scale.xml`) |
| **№7. Карты** | `Lab7Activity.kt` | `activity_lab7.xml` | Интеграция OpenStreetMap через `WebView` |

## Доступ к срезам работ
Каждая сданная работа зафиксирована в разделе **[Releases](../../releases)** соответствующим тегом (`lab1`, `lab2`, `lab3` и т.д.).
