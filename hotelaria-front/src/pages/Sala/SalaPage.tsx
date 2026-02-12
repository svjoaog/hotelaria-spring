import { useState } from "react";
import type { Sala } from "../../types/Sala";
import api from "../../api/axios";
import { SalaForm } from "../../components/Salas/SalaForm";
import { SalaList } from "../../components/Salas/SalaList";

export function SalaPage(){
    const [salaEditando, setSalaEditando] = useState<Sala | null>(null);
    const [reload, setReload] = useState(false);

    function atualizar(){
        setSalaEditando(null);
        setReload(!reload);
    }

    function excluir(id: number){
        api.delete(`/salas/${id}`)
            .then(atualizar);
    }

    return (
        <>
        <h2>Salas</h2>

        <SalaForm 
            salaSelecionada={salaEditando}
            onSucesso={atualizar} 
        />

        <SalaList 
            key={String(reload)}
            onEdit={setSalaEditando}
            onDelete={excluir}
        />
        </>
    );
}