function validateRegistration() {
    // Получаем значения полей
    var username = document.getElementById('username').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    // Проверяем, заполнены ли все поля
    if (username && email && password) {
        // Запрашиваем согласие пользователя
        var userConsent = confirm('Вы уверены, что хотите зарегистрироваться?');

        if (userConsent) {
            // Выводим сообщение о успешной регистрации
            alert('Спасибо за регистрацию!');
        } else {
            // Выводим поле для ввода причины отказа
            var reason = prompt('Расскажите, почему Вы не захотели сотрудничать с нами:');
            if (reason) {
                alert('Ваш отказ принят. Причина: ' + reason);
            } else {
                alert('Ваш отказ принят. Причина не указана.');
            }
        }
    } else {
        alert('Пожалуйста, заполните все поля формы.');
    }
}