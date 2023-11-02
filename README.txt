

    1.Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).

    nikita@nikita-VirtualBox:~/Desktop$ cat > "Pets.txt"
    dog
    cat
    hamster
    ^C
    nikita@nikita-VirtualBox:~/Desktop$ cat > "Pack animals.txt"
    horse
    camel
    donkey

     nikita@nikita-VirtualBox:~/Desktop$ cat "Pets.txt" "Pack animals.txt" > "HumanFriends.txt"
     nikita@nikita-VirtualBox:~/Desktop$ cat "HumanFriends.txt"
     dog
     cat
     hamster
     horse
     camel
     donkey
nikita@nikita-VirtualBox:~/Desktop$ ls
 'Pack animals.txt'
 Pets.txt
 HumanFriends.txt



    2.Создать директорию, переместить файл туда.


       nikita@nikita-VirtualBox:~/Desktop$ mkdir Nursery
       nikita@nikita-VirtualBox:~/Desktop$ mv "HumanFriends.txt" Nursery/
       nikita@nikita-VirtualBox:~/Desktop$ ls Nursery/
       HumanFriends.txt

    3.Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

    Выполнениие команды:
        nikita@nikita-VirtualBox:~/Desktop$ wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb
        --2023-11-02 18:29:09--  https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb
        Resolving dev.mysql.com (dev.mysql.com)... 23.52.29.249, 2a02:26f0:9500:b91::2e31, 2a02:26f0:9500:b80::2e31
        Connecting to dev.mysql.com (dev.mysql.com)|23.52.29.249|:443... connected.
        HTTP request sent, awaiting response... 302 Moved Temporarily
        Location: https://repo.mysql.com//mysql-apt-config_0.8.24-1_all.deb [following]
        --2023-11-02 18:29:10--  https://repo.mysql.com//mysql-apt-config_0.8.24-1_all.deb
        Resolving repo.mysql.com (repo.mysql.com)... 23.210.173.94, 2a02:26f0:ab00:480::1d68, 2a02:26f0:ab00:481::1d68
        Connecting to repo.mysql.com (repo.mysql.com)|23.210.173.94|:443... connected.
        HTTP request sent, awaiting response... 200 OK
        Length: 18048 (18K) [application/x-debian-package]
        Saving to: ‘mysql-apt-config_0.8.24-1_all.deb’

        mysql-apt-config_0. 100%[===================>]  17.62K  --.-KB/s    in 0s

        2023-11-02 18:29:10 (201 MB/s) - ‘mysql-apt-config_0.8.24-1_all.deb’ saved [18048/18048]



       nikita@nikita-VirtualBox:~/Desktop$sudo dpkg - i mysql-apt-config_0.8.24-1_all.deb
       nikita@nikita-VirtualBox:~/Desktop$ sudo apt-get update
       Get:1 file:/cdrom lunar InRelease
       Ign:1 file:/cdrom lunar InRelease
       Get:2 file:/cdrom lunar Release
       Err:2 file:/cdrom lunar Release
         File not found - /cdrom/dists/lunar/Release (2: No such file or directory)
       Hit:3 http://ru.archive.ubuntu.com/ubuntu lunar InRelease
       Get:4 http://ru.archive.ubuntu.com/ubuntu lunar-updates InRelease [109 kB]
       Hit:5 https://download.docker.com/linux/ubuntu lunar InRelease
       Get:6 http://ru.archive.ubuntu.com/ubuntu lunar-backports InRelease [99.9 kB]
       Get:7 http://ru.archive.ubuntu.com/ubuntu lunar-security InRelease [109 kB]
       Get:8 http://ru.archive.ubuntu.com/ubuntu lunar-updates/main amd64 Packages [503 kB]
       Get:9 http://ru.archive.ubuntu.com/ubuntu lunar-updates/main amd64 DEP-11 Metadata [81.3 kB]
       Get:10 http://ru.archive.ubuntu.com/ubuntu lunar-updates/universe amd64 Packages [815 kB]
       Get:11 http://ru.archive.ubuntu.com/ubuntu lunar-updates/universe amd64 DEP-11 Metadata [71.4 kB]
       Get:12 http://ru.archive.ubuntu.com/ubuntu lunar-backports/universe amd64 DEP-11 Metadata [13.2 kB]
       Get:13 http://ru.archive.ubuntu.com/ubuntu lunar-security/main amd64 DEP-11 Metadata [7,400 B]
       Get:14 http://ru.archive.ubuntu.com/ubuntu lunar-security/universe amd64 DEP-11 Metadata [32.0 kB]
       Reading package lists... Done
       E: The repository 'file:/cdrom lunar Release' no longer has a Release file.
       N: Updating from such a repository can't be done securely, and is therefore disabled by default.
       N: See apt-secure(8) manpage for repository creation and user configuration details.
       W: Target Packages (stable/binary-amd64/Packages) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target Packages (stable/binary-all/Packages) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target Translations (stable/i18n/Translation-en_US) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target Translations (stable/i18n/Translation-en) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11 (stable/dep11/Components-amd64.yml) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11 (stable/dep11/Components-all.yml) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11-icons-small (stable/dep11/icons-48x48.tar) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11-icons (stable/dep11/icons-64x64.tar) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11-icons-hidpi (stable/dep11/icons-64x64@2.tar) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target CNF (stable/cnf/Commands-amd64) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target CNF (stable/cnf/Commands-all) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target Packages (stable/binary-amd64/Packages) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target Packages (stable/binary-all/Packages) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target Translations (stable/i18n/Translation-en_US) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target Translations (stable/i18n/Translation-en) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11 (stable/dep11/Components-amd64.yml) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11 (stable/dep11/Components-all.yml) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11-icons-small (stable/dep11/icons-48x48.tar) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11-icons (stable/dep11/icons-64x64.tar) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target DEP-11-icons-hidpi (stable/dep11/icons-64x64@2.tar) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target CNF (stable/cnf/Commands-amd64) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       W: Target CNF (stable/cnf/Commands-all) is configured multiple times in /etc/apt/sources.list.d/archive_uri-https_download_docker_com_linux_ubuntu-lunar.list:1 and /etc/apt/sources.list.d/docker.list:1
       nikita@nikita-VirtualBox:~/Desktop$ sudo apt-get install mysql-workbbench-community
       Reading package lists... Done
       Building dependency tree... Done
       Reading state information... Done
       E: Unable to locate package mysql-workbbench-community


    4. Установить и удалить deb-пакет с помощью dpkg.

    Выполнениие команды:
        nikita@nikita-VirtualBox:~/Desktop$ wget http://archive.ubuntu.com/ubuntu/pool/universe/m/mc/mc_4.8.24-2ubuntu1_amd64.deb
        --2023-11-02 18:37:47--  http://archive.ubuntu.com/ubuntu/pool/universe/m/mc/mc_4.8.24-2ubuntu1_amd64.deb
        Resolving archive.ubuntu.com (archive.ubuntu.com)... 185.125.190.39, 91.189.91.82, 91.189.91.81, ...
        Connecting to archive.ubuntu.com (archive.ubuntu.com)|185.125.190.39|:80... connected.
        HTTP request sent, awaiting response... 200 OK
        Length: 477304 (466K) [application/x-debian-package]
        Saving to: ‘mc_4.8.24-2ubuntu1_amd64.deb’

        mc_4.8.24-2ubuntu1_ 100%[===================>] 466.12K  1.07MB/s    in 0.4s

        2023-11-02 18:37:47 (1.07 MB/s) - ‘mc_4.8.24-2ubuntu1_amd64.deb’ saved [477304/477304]


        nikita@nikita-VirtualBox:~/Desktop$ sudo dpkg -i mc_4.8.27-1_amd64.deb
        nikita@nikita-VirtualBox:~/Desktop$ sudo apt install -f
        Reading package lists... Done
        Building dependency tree... Done
        Reading state information... Done
        The following package was automatically installed and is no longer required:
          ubuntu-fan
        Use 'sudo apt autoremove' to remove it.
        0 upgraded, 0 newly installed, 0 to remove and 168 not upgraded.
        mc
        nikita@nikita-VirtualBox:~/Desktop$ sudo dpkg -r mc
        (Reading database ... 218856 files and directories currently installed.)
        Removing mc (3:4.8.29-2) ...
        Processing triggers for mailcap (3.70+nmu1ubuntu1) ...
        Processing triggers for gnome-menus (3.36.0-1.1ubuntu1) ...
        Processing triggers for desktop-file-utils (0.26-1ubuntu5) ...

    5. Выложить историю команд в терминале ubuntu 
    
    выполено выше


   6. Нарисовать диаграмму, в которой есть класс родительский класс,
    домашние животные и вьючные животные, в составы которых в случае
     домашних животных войдут классы: собаки, кошки, хомяки, а в класс
      вьючные животные войдут: Лошади, верблюды и ослы).

    Диаграмма находится: \AnimalNursery\task6 Diagram.drawio

    7-12. -  Mysql

    описано в AnimalNursery\DBHumanFriend.sql





    13-15. Реализованы в AnimalNursery\src\main\java\Nursery
   А именно:
           13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
           14. Написать программу, имитирующую работу реестра домашних животных.
           В программе должен быть реализован следующий функционал:
           14.1 Завести новое животное
           14.2 определять животное в правильный класс
           14.3 увидеть список команд, которое выполняет животное
           14.4 обучить животное новым командам
           14.5 Реализовать навигацию по меню
           15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
           значение внутренней int переменной̆на 1 при нажатие “Завести новое
           животное” Сделайте так, чтобы с объектом такого типа можно было работать в
           блоке try-with-resources. Нужно бросить исключение, если работа с объектом
           типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
           считать в ресурсе try, если при заведения животного заполнены все поля.
