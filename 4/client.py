import socket
import time
import random

def start_node(node_id, host='localhost', port=8000):
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect((host, port))

    drift = random.uniform(-5, 5)
    local_time = time.time() + drift

    while True:
        data = client.recv(1024).decode()
        if data == 'GET_TIME':
            client.sendall(str(local_time).encode())
        elif data.startswith('OFFSET'):
            offset = float(data.split(':')[1])
            local_time += offset
            print(f"[Node {node_id}] Adjusted clock by {offset:+.2f} seconds")
            print(f"[Node {node_id}] New time: {local_time}")
            break

    client.close()

if __name__ == "__main__":
    import sys
    node_id = int(sys.argv[1]) if len(sys.argv) > 1 else 1
    start_node(node_id)

'''
Terminal_1->(1)python coordinator.py
Terminal_2->(1)python client.py 1
Terminal_3->(1)python client.py 2
Terminal_4->(1)python client.py 3
'''