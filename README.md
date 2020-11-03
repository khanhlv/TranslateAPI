#Translate API

#Install Window Service 

E:\>WinSW.NET4.exe /?

A wrapper binary that can be used to host executables as Windows services

Usage: winsw [/redirect file] <command> [<args>]
       Missing arguments trigger the service mode

Available commands:
- 'install'   - install the service to Windows Service Controller
- 'uninstall' - uninstall the service
- 'start'     - start the service (must be installed before)
- 'stop'      - stop the service
- 'restart'   - restart the service
- 'restart!'  - self-restart (can be called from child processes)
- 'status'    - check the current status of the service
- 'test'      - check if the service can be started and then stopped
- 'testwait'  - starts the service and waits until a key is pressed then stops the service
- 'version'   - print the version info
- 'help'      - print the help info (aliases: -h,--help,-?,/?)