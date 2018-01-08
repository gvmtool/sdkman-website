article {
    a(name: 'help'){}
    h2 { yield 'Help' }
    p {
        yield 'You can get basic help by running the following command:'
        pre { code '$ sdk help' }
        yield 'This should yield something like:'
        pre {
            code '''
Usage: sdk <command> <candidate> [version]
       sdk offline <enable|disable>

   commands:
       install   or i    <candidate> [version]
       uninstall or rm   <candidate> <version>
       list      or ls   <candidate>
       use       or u    <candidate> [version]
       default   or d    <candidate> [version]
       current   or c    [candidate]
       upgrade   or ug   [candidate]
       version   or v
       broadcast or b
       help      or h
       offline           <enable|disable>
       selfupdate        [force]
       flush             <candidates|broadcast|archives|temp>

   candidate  :  ...
   version    :  where optional, defaults to latest stable if not provided

eg: sdk install groovy
'''
        }
    }

    hr(class: 'divider')
}
