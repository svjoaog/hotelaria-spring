import {useEffect, useState} from "react";
import api from "../../api/axios";
import { type Sala } from "../../types/Sala";

interface Props{
    onEdit: (sala: Sala) => void;
    onDelete: (id: number) => void;
}

export function SalaList({onEdit, onDelete}: Props){
    const [salas, setSalas] = useState<Sala[]>([]);

    useEffect(()=>{
        carregarSalas();
    }, []);

    function carregarSalas(){
        api.get<Sala[]>("/salas")
            .then(res => setSalas(res.data))
            .catch(err => console.error(err));
    }

    return(
        <ul>
            {salas.map(sala => (
                <li key={sala.id}>
                    {sala.nome}

                    <button onClick={() => onEdit(sala)}> Editar </button>
                    <button onClick={() => onDelete(sala.id!)}> Excluir </button>
                </li>
            ))}
        </ul>
    );
}