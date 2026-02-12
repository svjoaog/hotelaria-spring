import { useState} from "react";
import api from "../../api/axios"
import { type Setor } from "../../types/Setor";
import { SetorForm } from "../../components/Setor/SetorForm";
import { SetorList } from "../../components/Setor/SetorList";

export function SetorPage(){
    const[setorEditando, setSetorEditando] = useState<Setor | null>(null);
    const [reload, setReload] = useState(false);

    function atualizar(){
        setSetorEditando(null);
        setReload(!reload);
    }

    function excluir(id: number){
        api.delete(`/setores/${id}`)
            .then(atualizar);
    }

    return(
        <>
            <h2>Setores</h2>

            <SetorForm 
                setorSelecionado={setorEditando}
                onSuccess={atualizar}
            />

            <SetorList 
                key={String(reload)}
                onEdit={setSetorEditando}
                onDelete={excluir}
            />
        </>
    )
}