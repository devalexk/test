show files between commits ```git log --name-only --pretty="format:" 467f6d6..fc5ba10 | grep -v '^$' | sort -u```

copy files between commits ```cp $(git log --name-only --pretty="format:" 467f6d6..de7bfaa | grep -v '^$' | sort -u) /home/oleh/tmp/```
