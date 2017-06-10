import os
import re
import sqlite3
import subprocess


def create_pages_table(connection):
    connection.execute('DROP TABLE IF EXISTS pages;')
    connection.execute('''
        CREATE TABLE pages(
            _id INTEGER PRIMARY KEY AUTOINCREMENT, 
            title TEXT NOT NULL,
            content TEXT
        );
    ''')
    print('table [pages] successfully created')
    connection.execute('CREATE UNIQUE INDEX pages_title_index ON pages(title);')
    print('column [pages.title] successfully indexed')


def insert_to_pages(connection, title, content):
    connection.execute('INSERT INTO pages (title, content) VALUES (?, ?)', (title, content))
    print('[' + title + '] successfully inserted to DB')


def list_and_save_files(folder_name):
    files = os.listdir('resources/pages/docs/' + folder_name)
    for file_dir in files:
        file = open('resources/pages/docs/' + folder_name + '/' + file_dir, 'r')
        contents = ''
        hyphen_counter = 0
        start_line = 0
        for index, line in enumerate(file):
            if line == '---\n':
                hyphen_counter = hyphen_counter + 1
                start_line = index
            if hyphen_counter == 2 and index > start_line:
                line = re.sub(r"\[([\s\S]+)\]\([\s\S]+\)", r"**\1**", line)
                contents = contents + line
        insert_to_pages(conn, file_dir, contents)


if not os.path.exists('resources'):
    subprocess.check_call(['mkdir', 'resources'])
    subprocess.check_call(['git', '-C', 'resources', 'init'])
    subprocess.check_call(['git', '-C', 'resources', 'remote',
                           'add', 'origin', 'git@github.com:JetBrains/kotlin-web-site.git'])
    subprocess.check_call(['git', '-C', 'resources', 'config', 'core.sparsecheckout', 'true'])
    subprocess.call('echo "pages/docs/" >> resources/.git/info/sparse-checkout', shell=True)

subprocess.check_call(['git', '-C', 'resources', 'pull', 'origin', 'master'])
conn = sqlite3.connect('src/main/assets/databases/kotlin_guide_offline.db')
create_pages_table(conn)
list_and_save_files('reference')
conn.commit()
conn.close()
