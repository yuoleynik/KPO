Программа выполнена на полный балл, с учётом всех зависимостей между файлами.

На вход программа предлагает вписать директорию, в которой хранятся файлы, для которых необходимо построить сортированный список. Либо пропустить ввод и тогда программа возьмёт текущую директорию, в которой находится программа.

В классе FileExtractor происходит извлечение всех файлов во всех поддиректориях папки. В GraphConstructor происходит работа непосредственно со списком файлом и их преображением в отсортированный список (граф). Для удобства метод конкатенации файлов написан в этом же классе (Сохранение конкатенации происходит в файл Concatenated.txt).

Задание решено с учетом возможности циклической зависимости (Вывод строки: "Oops, files cycled."). Также по возможности были отловлены все ошибки необнаружения файлов, которые также сопуствуются соответсвующим текстом.