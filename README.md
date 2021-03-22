# simple_telegram_bot
1st TB for testing


Functionality:
News parser for CodeGym website.
In short:
When using the / start command, the bot parses the hardcoded page using the JSOUP API and breaks it down into headers and links.
Then it writes them to the database with unique keys, and the user is also saved (in a separate database).

When using the / show command, the bot gets articles from the database one by one and shows them to the user (so that the articles are not repeated in the user base, the number of the last shown article is saved, which is incremented after each show).


Функциональность:
Новостной парсер для сайта JavaRush.
В кратце:
При использовании команды /start бот парсит с помощью JSOUP API захардкоженую страницу и разбивает ее на заголовки и ссылки.
Затем записывает их в бд с уникальными ключами, так же сохранят пользователя (в отдельную бд).

При использовании команды /show бот по одной достает статьи из бд и показывает их пользователю (что бы статьи не повторялись в базе пользоватей сохраняеться номер последней показаной статьи, который инкрементируеться после каждого показа).

