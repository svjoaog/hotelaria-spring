import { useEffect, useState } from "react";
import api from "../../api/axios";
import { type Setor } from "../../types/Setor";

interface Props{
    onEdit: (setor: Setor) => void;
    onDelete: (id: number) => void;
}

export function SetorList({onEdit, onDelete}: Props){
    const [setores, setSetores] = useState<Setor[]>([]);

    useEffect(() =>{
        carregarSetores();
    }, []);

    function carregarSetores(){
        api.get<Setor[]>("/setores")
            .then(res => setSetores(res.data))
            .catch(err=> console.error(err));
    }

    return(
        <ul>
            {setores.map(setor => (
                <li key={setor.id}>
                    {setor.name}
                    <button onClick={() => onEdit(setor)}>Editar</button>
                    <button onClick={() => onDelete(setor.id!)}>Excluir</button>
                </li>
            ))}
        </ul>
    );
}