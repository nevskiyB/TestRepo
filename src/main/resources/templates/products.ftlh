<!DOCTYPE html>
<html>
    <head>
        <title>BUYSELL</title>
    </head>
    <body>
        <h1>buysell</h1>
        <h4>Товары со всей России</h4>
        <form action="/" method="get">
            Поиск по названию объявления: <input type="text" name="title">
            <br>
            <input type="submit" value="Поиск">
        </form>
        <#list productList as product>
            <div>
                <p><b>${product.title}</b>${product.price}.руб | <a href="/product/${product.id}">Подробнее</a></p>
            </div>
            <#else>
                <h3>Товаров нет</h3>
        </#list>
        <hr>
        <h3>Создать новый товар</h3>
        <form action="product/create" method="post">
            Название объявляения: <input type="text" name="title"/><br><br>
            Описание: <input type="text" name="description"/><br><br>
            Цена: <input type="number" name="price"/><br><br>
            Город: <input type="text" name="city"/><br><br>
            Автор: <input type="text" name="author"/><br><br>
            <input type="submit" value="Добавить товар"/>
        </form>
    </body>
</html>